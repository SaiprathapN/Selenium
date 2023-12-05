
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

@Component("LIC14274_PJT1002_PE_NLPbf10d4e3-5aba-47fb-88ea-ac0c1c3c0489")
public class Convert_String_To_Array implements Nlp {
    @InputParams({@InputParam(name = "text", type = "java.lang.String")})
    @ReturnType(name = "sizeOfText", type = "java.lang.Integer")

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
          String getText = (String) attributes.get("text");
          //String string2 = (String) attributes.get("string2");
          int sizeOf = 0;
          try {
        	  String s1= getText;
        	  char[] ch = new char[s1.length()];
      		
      		for (int i = 0; i < s1.length(); i++) {
                  ch[i] = s1.charAt(i);
              }
      		
      		sizeOf = ch.length;
      		nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully converted to array");
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Convert string to array failed");
		}

          // Your program element business logic goes here ...

          //String string3 = "Return Value";
          nlpResponseModel.getAttributes().put("sizeOfText", sizeOf);
          return nlpResponseModel;
      }
  } 