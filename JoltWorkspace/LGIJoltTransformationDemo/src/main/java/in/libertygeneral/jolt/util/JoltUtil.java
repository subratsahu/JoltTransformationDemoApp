package in.libertygeneral.jolt.util;


import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


public class JoltUtil {
	
	public static <T> T getEntity(String spec, Class<T> entityClass, Object inputJson) {
        List chainrSpecJSON = JsonUtils.classpathToList(spec);
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
        Object transformedOutput = chainr.transform(inputJson);
        System.out.println("Transformed JSON with "+spec+"(Spec File)"+new Gson().toJson(transformedOutput));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(transformedOutput, entityClass);
    }
}
