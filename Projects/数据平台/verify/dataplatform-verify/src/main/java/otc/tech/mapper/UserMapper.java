package otc.tech.mapper;

import org.apache.ibatis.annotations.Mapper;

import otc.tech.base.mapper.BaseMapper;
import otc.tech.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
