package com.company.usermessagerela.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.enums.MessageCenterState;
import com.company.enums.UserMessageRelaState;
import com.company.messagecenter.dao.MessageCenterMapper;
import com.company.messagecenter.model.MessageCenter;
import com.company.messagecenter.model.MessageCenterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.usermessagerela.service.UserMessageRelaService;
import com.company.usermessagerela.dao.UserMessageRelaMapper;
import com.company.usermessagerela.model.UserMessageRela;
import com.company.usermessagerela.model.UserMessageRelaExample;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserMessageRelaServiceImpl extends BaseServiceImpl<UserMessageRela, UserMessageRelaExample> implements UserMessageRelaService<UserMessageRela, UserMessageRelaExample>{

    @Autowired
    private UserMessageRelaMapper mapper;

	@Autowired
	private MessageCenterMapper messageCenterMapper;
	
	public IBaseDao<UserMessageRela, UserMessageRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 发布消息
	 * @param info
	 *              消息信息列表 赋值 info.mgList
	 *              用户信息列表 赋值 info.userList
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveForMe(UserMessageRela info) throws BaseException {
		if(info == null){
			throw new BaseException("参数信息对象为空。");
		}
		//消息信息列表
		List<String> mgList = info.getMgList();
		if(mgList == null || mgList.size() == 0){
			throw new BaseException("参数信息--消息信息列表为空。");
		}
		//用户信息列表
		List<Map<String, String>> userMapList = info.getUserMapList();
		if(userMapList == null || userMapList.size() == 0){
			throw new BaseException("参数信息--用户信息列表为空。");
		}
		for(String _mgId : mgList){
			//消息ID
			String mgId = _mgId;
			for(Map<String, String> userMap : userMapList){
				//用户ID
				String userId = userMap.get("code");
				String userName = userMap.get("label");
				UserMessageRela userRela = new UserMessageRela();
				userRela.setCreateUser(info.getCreateUser());
				userRela.setCreateTime(new Date());
				userRela.setMgid(mgId);
				userRela.setUserid(userId);
				userRela.setUsername(userName);
				userRela.setUsermgstate(UserMessageRelaState.UNREAD.getCode());
				UserMessageRelaExample example = new UserMessageRelaExample();
				UserMessageRelaExample.Criteria criteria = example.createCriteria();
				criteria.andMgidEqualTo(mgId);
				criteria.andUseridEqualTo(userId);
				List<UserMessageRela> list = getMapper().selectByExample(example);
				//若存在则不发布
				//若不存在则发布
				if(list == null ||  list.size() == 0){
					int success = getMapper().insertSelective(userRela);
					if (success <= 0) {
						logger.error("发布消息{}",  userRela.toString());
					throw new BaseException("发布消息错误");
					}
				}
			}
			MessageCenterExample mcExample = new MessageCenterExample();
			MessageCenterExample.Criteria mcCriteria = mcExample.createCriteria();
			mcCriteria.andIdEqualTo(mgId);
			mcCriteria.andMgstateEqualTo(MessageCenterState.DRAFT.getCode());
			MessageCenter mc = new MessageCenter();
			mc.setMgstate(MessageCenterState.PUBLISH.getCode());
			//修改消息信息由草稿变为发布状态
			messageCenterMapper.updateByExampleSelective(mc, mcExample);
		}
	}

	/**
	 * 全部撤回消息
	 * @param info
	 *              消息信息列表 赋值 info.mgList
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void delForAll(UserMessageRela info) throws BaseException {
		if(info == null){
			throw new BaseException("参数信息对象为空。");
		}
		//消息ID
		String mgId = info.getMgid();
		if(mgId == null || mgId.length() == 0){
			throw new BaseException("参数信息--消息ID为空。");
		}
		List<String> mgIdStrList = new ArrayList<>();
		mgIdStrList.add(mgId);
		MessageCenterExample mcExample = new MessageCenterExample();
		MessageCenterExample.Criteria mcCriteria = mcExample.createCriteria();
		mcCriteria.andIdEqualTo(mgId);
		mcCriteria.andMgstateEqualTo(MessageCenterState.PUBLISH.getCode());
		MessageCenter mc = new MessageCenter();
		mc.setMgstate(MessageCenterState.DRAFT.getCode());
		//修改消息信息由发布变为草稿状态
		messageCenterMapper.updateByExampleSelective(mc, mcExample);
		UserMessageRelaExample example = new UserMessageRelaExample();
		UserMessageRelaExample.Criteria criteria = example.createCriteria();
		criteria.andMgidIn(mgIdStrList);
		int success = getMapper().deleteByExample(example);
		if (success <= 0) {
			logger.error("全部撤回消息{}",  mgIdStrList.toString());
			throw new BaseException("全部撤回消息错误");
		}
	}

	/**
	 * 部分撤回消息
	 * @param info
	 *              消息信息列表 赋值 info.mgList
	 *              用户信息列表 赋值 info.userList
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void delForPart(UserMessageRela info) throws BaseException {
		if(info == null){
			throw new BaseException("参数信息对象为空。");
		}
		//消息ID
		String mgId = info.getMgid();
		if(mgId == null || mgId.length() == 0){
			throw new BaseException("参数信息--消息ID为空。");
		}
		//用户信息列表
		List<String> userList = info.getUserList();
		if(userList == null || userList.size() == 0){
			throw new BaseException("参数信息--用户信息列表为空。");
		}
		for(String _userId : userList){
			//用户ID
			String userId = _userId;
			UserMessageRela userRela = new UserMessageRela();
			userRela.setMgid(mgId);
			userRela.setUserid(userId);
			UserMessageRelaExample example = new UserMessageRelaExample();
			UserMessageRelaExample.Criteria criteria = example.createCriteria();
			criteria.andMgidEqualTo(mgId);
			criteria.andUseridEqualTo(userId);
			int success = getMapper().deleteByExample(example);
			if (success <= 0) {
				logger.error("部分撤回消息{}",  userRela.toString());
				throw new BaseException("部分撤回消息错误");
			}
		}

		UserMessageRelaExample example = new UserMessageRelaExample();
		UserMessageRelaExample.Criteria criteria = example.createCriteria();
		criteria.andMgidEqualTo(mgId);
		//查询该消息id是否存在关系数据
		List<UserMessageRela> list = getMapper().selectByExample(example);
		//若存在则发布
		String mgState = MessageCenterState.PUBLISH.getCode();
		if(list == null ||  list.size() == 0){
			//若不存在则草稿
			mgState = MessageCenterState.DRAFT.getCode();
		}
		MessageCenterExample mcExample = new MessageCenterExample();
		MessageCenterExample.Criteria mcCriteria = mcExample.createCriteria();
		mcCriteria.andIdEqualTo(mgId);
		mcCriteria.andMgstateEqualTo(MessageCenterState.PUBLISH.getCode());
		MessageCenter mc = new MessageCenter();
		mc.setMgstate(mgState);
		//修改消息信息由发布变为全部或部分撤回状态
		messageCenterMapper.updateByExampleSelective(mc, mcExample);
	}
}