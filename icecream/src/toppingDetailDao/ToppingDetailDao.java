package toppingDetailDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ToppingDetailDao {

	private JdbcTemplate jdbcTemplate;
	
	public ToppingDetailDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void createToppingDetail(String json, int detailId, List<String> detailList) {
		String sql = "";
		String jsonList[] = splitString(json);
		// -- 주문 덩어리 카운트 
		int cnt = jsonList.length;
				System.out.println("cnt > "+cnt);
				int iceCnt = Integer.parseInt(jsonList[cnt-2]);
				System.out.println("iceCnt > "+iceCnt);
				System.out.println(detailList);
				
				for(int i=0;i<detailList.size();i++) {
					 if(i == 0) {
						 System.out.println("i == 0 > "+detailList.get(i));
					 }else {
						 System.out.println("실제 값 "+detailList.get(i));
						 sql = "insert into icecream.toppingdetail(ToppingDetailID,OrderDetailID,"
						 		+ "ToppingID,ToppingQuantity) values(0,"+detailId+",'"+detailList.get(i)+"',"
						 				+ "1)";
						 jdbcTemplate.update(sql);
					 }
				}
//		 for(int j=1;j<=iceCnt;j++) {
//			 List<String> list = splitAndFilterValues(json, Integer.toString(j));
//			 System.out.println(list);
//			 System.out.println("list.size() > "+list.size());
//			 
//		 }
//		 for(int i = 0; i<list.size();i++) {
//			 if(i == 0) {
//				 System.out.println("i == 0 > "+list.get(i));
//			 }else {
//				 System.out.println("실제 값 "+list.get(i));
//				 sql = "insert into icecream.toppingdetail(ToppingDetailID,OrderDetailID,"
//				 		+ "ToppingID,ToppingQuantity) values(0,"+detailId+",'"+list.get(i)+"',"
//				 				+ "1)";
//				 jdbcTemplate.update(sql);
//			 }
//			
//			 //오류 가능성
////			 total = total + jdbcTemplate.queryForObject(sql, Integer.class);
//		 }
	}
	
    private List<String> splitAndFilterValues(String input, String prefix) {
        List<String> values = new ArrayList<>();
        
        String[] parts = splitString(input);

        for (int i = 0; i < parts.length; i += 2) {
            String key = parts[i];
            if (key.startsWith(prefix)) {
                values.add(parts[i + 1]);
            }
        }
        
        return values;
    }

    private String[] splitString(String input) {
        return input.split("[=&]");
    }
    
    public List<String> selectTopIdByDetailId(int detailId) {
    	String sql = "select toppingID from toppingdetail where OrderDetailID = "+detailId;
    	List<String> list = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String topping = rs.getString("toppingId");
				return topping;
			}
    		
    	});
    	return list;
    }

}
