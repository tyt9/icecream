package mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDAO {
	
//	@Select("select * from member")//xml 대신
//	List<Member> selectAll();
//	
//	int selectCount();
//	
//	List<Member> selectList();
//	
//	Member selectById(String id);
//	
//	void updateArticle(String title, int num);
//	
//	void insertArtCont(@Param("artCon") ArticleContent articleContent);
//	
//	void insertArticle(@Param("art") Article article);
}
