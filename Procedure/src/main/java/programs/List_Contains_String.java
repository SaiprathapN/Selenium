
package programs;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LIC14274_PJT1002_PE_NLPc9f4a985-5850-435f-b88a-f09bbe5701f4")
public class List_Contains_String implements Nlp {
	@InputParams({@InputParam(name = "givenList", type = "java.util.List"),@InputParam(name = "string", type = "java.lang.String")})
	@ReturnType(name = "result", type = "java.lang.Boolean")

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		List<String> l = (List<String>) attributes.get("givenList");
		String str = (String) attributes.get("string");
		Boolean result = false;
		// Your program element business logic goes here ...
		String [] strArr = null;
		if (str.contains(" ")) {
			strArr=str.split(" ");
			try {
				for (String ele : l) {
					for (int i = 0; i < strArr.length; i++) {
						if (ele.contains(strArr[i])) {
							result = true;
							break;
						}
						else {
							result = false;
						}
					}
				}
				if (result) {
					nlpResponseModel.setMessage("Each Element Contains "+str);
					nlpResponseModel.setStatus(CommonConstants.pass);
				}else {
					nlpResponseModel.setMessage("Each Element not Contains "+str);
					nlpResponseModel.setStatus(CommonConstants.fail);
				}

			} catch (Exception e) {
				nlpResponseModel.setMessage("Invalid List Format");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}
		}else {
			try {
				for (String ele : l) {
					if (ele.contains(str)) {
						result = true;
						break;
					}
					else {
						result = false;
					}
				}
				if (result) {
					nlpResponseModel.setMessage("Each Element Contains "+str);
					nlpResponseModel.setStatus(CommonConstants.pass);
					
				}else {
					nlpResponseModel.setMessage("Each Element not Contains "+str);
					nlpResponseModel.setStatus(CommonConstants.fail);
					
				}

			} catch (Exception e) {
				nlpResponseModel.setMessage("Invalid List Format");
				nlpResponseModel.setStatus(CommonConstants.fail);
			}
		}
		nlpResponseModel.getAttributes().put("result", result);
		return nlpResponseModel;
	}
} 