package com.company.messagecenter.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.enums.MessageCenterState;
import com.company.usermessagerela.dao.UserMessageRelaMapper;
import com.company.usermessagerela.model.UserMessageRelaExample;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.messagecenter.service.MessageCenterService;
import com.company.messagecenter.dao.MessageCenterMapper;
import com.company.messagecenter.model.MessageCenter;
import com.company.messagecenter.model.MessageCenterExample;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageCenterServiceImpl extends BaseServiceImpl<MessageCenter, MessageCenterExample> implements MessageCenterService<MessageCenter, MessageCenterExample>{

    @Autowired
    private MessageCenterMapper mapper;

	@Autowired
	private UserMessageRelaMapper userMessageRelaMapper;

	public IBaseDao<MessageCenter, MessageCenterExample> getMapper(){
		return mapper;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateForMe(MessageCenter model) throws BaseException {
		//之前的状态
		String mgState = model.getMgstate();
		//保存则变为草稿状态
		model.setMgstate(MessageCenterState.DRAFT.getCode());
		int success = getMapper().updateByPrimaryKeySelective(model);
		if (success <= 0) {
			logger.error("更新实体错误{}",  model.toString());
			throw new BaseException("更新实体错误");
		} else {
			if(!mgState.equals(MessageCenterState.DRAFT.getCode())){
				String mgId = model.getId();
				//若是编辑实体之前的状态不是草稿时，将删除该消息的关联关系数据
				UserMessageRelaExample urExample = new UserMessageRelaExample();
				UserMessageRelaExample.Criteria criteria = urExample.createCriteria();
				criteria.andMgidEqualTo(mgId);
				int delSuccess = userMessageRelaMapper.deleteByExample(urExample);
				if (delSuccess <= 0) {
					logger.error("全部撤回消息{}",  mgId.toString());
					throw new BaseException("全部撤回消息错误");
				}
			}
		}
		return;

	}
}