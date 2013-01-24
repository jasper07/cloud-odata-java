package com.sap.core.odata.core.uri.expression;

import com.sap.core.odata.api.edm.Edm;
import com.sap.core.odata.api.edm.EdmEntityType;
import com.sap.core.odata.api.rt.RuntimeDelegate;
import com.sap.core.odata.testutil.mock.TecEdmInfo;
import com.sap.core.odata.testutil.mock.TechnicalScenarioEdmProvider;

public class TestBase {
  
  public TestBase()
  {
    edm = RuntimeDelegate.createEdm(new TechnicalScenarioEdmProvider());
    edmInfo = new TecEdmInfo(edm);
  }

  static public ParserTool GetPTF(String expression)
  {
    return new ParserTool(expression, false, true);
  }
  
  static public ParserTool GetPTFE(String expression)
  {
    return new ParserTool(expression, false, true);
  }
  static public ParserTool GetPTF(Edm edm, EdmEntityType resourceEntityType, String expression) 
  {
    return new ParserTool(expression, false, true, edm, resourceEntityType);
  }

  static public ParserTool GetPTO(String expression)
  {
    return new ParserTool(expression, true, true);
  }

  static public ParserTool GetPTO(Edm edm, EdmEntityType resourceEntityType, String expression) 
  {
    return new ParserTool(expression, true, true, edm, resourceEntityType);
  }

  static public ParserTool GetPTF_noTEST(String expression)
  {
    return new ParserTool(expression, false, false);
  }

  static public ParserTool GetPTF_noTEST(Edm edm, EdmEntityType resourceEntityType, String expression) 
  {
    return new ParserTool(expression, false, false, edm, resourceEntityType);
  }

  static public ParserTool GetPTO_noTEST(String expression)
  {
    return new ParserTool(expression, true, false);
  }

  static public ParserTool GetPTO_noTEST(Edm edm, EdmEntityType resourceEntityType, String expression) 
  {
    return new ParserTool(expression, true, false, edm, resourceEntityType);
  }

  protected Edm edm = null;
  protected TecEdmInfo edmInfo = null;

}
