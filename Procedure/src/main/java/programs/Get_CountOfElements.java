
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component("LIC14274_PJT1002_PE_NLPfdf5030e-05a9-419e-9034-6193d6870b44")
public class Get_CountOfElements implements Nlp {
    @InputParams({@InputParam(name = "elements", type = "java.lang.String")})
    @ReturnType(name = "count", type = "java.lang.Integer")

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
          String listOfElement = (String) attributes.get("elements");
          String count = (String) attributes.get("count");
          WebDriver driver=nlpRequestModel.getWebDriver();
          int sizeOfEle=0;
          try {
        	  List<WebElement> countOfEle = driver.findElements(By.xpath(listOfElement));
        	  sizeOfEle = countOfEle.size();
        	  nlpResponseModel.setStatus(CommonConstants.pass);
  			nlpResponseModel.setMessage("Succesfully fetched size");
        	  
			
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Unable to fetch the size");
		}
          // Your program element business logic goes here ...

          //String count = "Return Value";
          nlpResponseModel.getAttributes().put("count", sizeOfEle);
          return nlpResponseModel;
      }
  } 