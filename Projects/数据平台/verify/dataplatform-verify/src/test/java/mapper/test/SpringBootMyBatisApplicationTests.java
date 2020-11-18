package mapper.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import otc.tech.ServiceApplication;
import otc.tech.base.mapper.BaseMapper;
import otc.tech.mapper.ReportTypesMapper;
import otc.tech.mapper.TemplateMapper;
import otc.tech.mapper.UserMapper;
import otc.tech.model.ReportTypes;
import otc.tech.model.Template;
import otc.tech.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootMyBatisApplicationTests {

	@Autowired
    private TemplateMapper mapper;
	
	
	@Test
	public void selectAll() {
		//List<TabReportTypes> list = mapper.selectAll();
		Template te = new Template();
		te.settTemplateType("300201");
		List<String> f = mapper.selectTupleName(te);
		System.err.println(f);
		
	}
	
	
}
