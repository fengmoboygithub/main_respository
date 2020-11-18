package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.FileinfoMediaRela;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;

@Repository
public interface FileinfoMediaRelaDao {

	public int addFileinfoMedia(FileinfoMediaRela fileinfoMediaRela);
	
	public int updateSort(@Param("mediaId") long mediaId,@Param("fileId") long fileId,
			@Param("sort") int sort);

	public int deleteFileinfoMedia(@Param("fileId") long fileId,
			@Param("mediaId") long mediaId);
	
	public int deleteFileinfoMediaByFileId(@Param("fileId") long fileId);
	
	public int deleteFileinfoMediaByMediaId(@Param("mediaId") long mediaId);

	public List<FileinfoMediaRelaVo> getFileinfoMediaListByFileId(
			@Param("fileId") long fileId);
	
	public FileinfoMediaRelaVo getFileinfoMediaByfileIdAndmediaId(@Param("fileId") long fileId,
			@Param("mediaId") long mediaId);
}
