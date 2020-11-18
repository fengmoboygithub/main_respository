package otc.tech.validator;

import java.util.Map;

/**
 * 校验
 */
public interface Validator {

	/**
	 * 报告校验
	 * 
	 * @param options
	 * @return
	 */
	public Map<String, Object> verify(Options options) throws Exception;

}
