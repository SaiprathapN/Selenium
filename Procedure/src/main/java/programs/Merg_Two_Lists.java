
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

@Component("LIC14274_PJT1002_PE_NLPf894bec6-dd85-4f14-80e7-03f389e0d789")
public class Merg_Two_Lists implements Nlp {
    @InputParams({@InputParam(name = "list1", type = "java.util.List"), @InputParam(name = "list2", type = "java.util.List")})
    @ReturnType(name = "list3", type = "java.util.List")

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
          List l1 = (List) attributes.get("list1");
          List l2 = (List) attributes.get("list2");

          // Your program element business logic goes here ...
          List fList = new ArrayList();
          try {	  
      		for (int i = 0; i < l1.size(); i++) {
      			fList.add(l1.get(i)+" - "+l2.get(i));
      		}
      		nlpResponseModel.setMessage("Merge Successful");
      		nlpResponseModel.setStatus(CommonConstants.pass);
		} catch (Exception e) {
			nlpResponseModel.setMessage("Merge Failure : Invalid List Sizes");
      		nlpResponseModel.setStatus(CommonConstants.fail);
		}  
          nlpResponseModel.getAttributes().put("list3", fList);
          return nlpResponseModel;
      }
  } 