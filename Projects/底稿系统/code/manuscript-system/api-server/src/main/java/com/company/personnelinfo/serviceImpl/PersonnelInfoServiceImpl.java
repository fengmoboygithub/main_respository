package com.company.personnelinfo.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.enums.RequestParameterType;
import com.company.projectinfo.serviceImpl.ProjectInfoServiceImpl;
import com.company.utils.HttpClientUtils;
import com.company.utils.HttpUtil;
import com.github.pagehelper.PageInfo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.personnelinfo.service.PersonnelInfoService;
import com.company.personnelinfo.dao.PersonnelInfoMapper;
import com.company.personnelinfo.model.PersonnelInfo;
import com.company.personnelinfo.model.PersonnelInfoExample;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonnelInfoServiceImpl extends BaseServiceImpl<PersonnelInfo, PersonnelInfoExample> implements PersonnelInfoService<PersonnelInfo, PersonnelInfoExample>{

    public static Logger logger = LoggerFactory.getLogger(PersonnelInfoServiceImpl.class);

    @Autowired
    private PersonnelInfoMapper mapper;

    /**
     * 统一账户管理外部调用url
     */
    @Value("${web.user-system-url}")
    private String userSystemUrl;
	
	public IBaseDao<PersonnelInfo, PersonnelInfoExample> getMapper(){
		return mapper;
	}

    public static void main(String[] args) {
        Map<String, Object> loginfo = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("pageNum", "1");
        map.put("pageSize", "100");
        map.put("status", "0");
        loginfo = HttpUtil.HttpRequestutil(map, "http://10.0.48.60:30010/tyzhapi/api/system/user/selectUserList", RequestMethod.POST, RequestParameterType.BODY);
        System.out.println(loginfo.toString());
        if ("0".equals(loginfo.get("code").toString())) {
            System.out.println((Integer)loginfo.get("total"));
            ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>)loginfo.get("rows");
            list.forEach(x -> System.out.println(x.get("userName")+","+x.get("userId")));
        }
    }

    @Override
    public PageInfo<PersonnelInfo> getListByPageForUserSys(int currentPage, int itemsPerPage) throws BaseException {
        Map<String, Object> loginfo = null;
	    try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("pageNum", currentPage+"");
            map.put("pageSize", itemsPerPage+"");
            map.put("status", "0");
            loginfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/user/selectUserList", RequestMethod.POST, RequestParameterType.BODY);
            if ("0".equals(loginfo.get("code").toString())) {
                logger.info(loginfo.toString());
            }
        } catch (Exception e) {
            logger.error("根据条件分页查询用户对象错误信息：", e);
            throw new BaseException("根据条件分页查询用户对象错误信息");
        }
        PageInfo<PersonnelInfo> page = new PageInfo<PersonnelInfo>();
        if(loginfo != null){
            Integer total = (Integer)loginfo.get("total");
            page.setTotal(total);
            ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>)loginfo.get("rows");
            List<PersonnelInfo> pList = new ArrayList<PersonnelInfo>();
            list.forEach(x -> {
                PersonnelInfo personnelInfo = new PersonnelInfo();
                Integer userId = (Integer)x.get("userId");
                personnelInfo.setId(userId+"");
                personnelInfo.setName((String)x.get("userName"));
                pList.add(personnelInfo);
            });
            page.setList(pList);
        }
        return page;
    }
}