package com.sap.core.odata.core.edm.simpletype;

import com.sap.core.odata.api.edm.EdmException;
import com.sap.core.odata.api.edm.EdmFacets;
import com.sap.core.odata.api.edm.EdmLiteralKind;
import com.sap.core.odata.api.edm.EdmSimpleType;
import com.sap.core.odata.api.edm.EdmSimpleTypeKind;
import com.sap.core.odata.api.edm.EdmTypeKind;

public class EdmBoolean implements EdmSimpleType {

  private EdmSimpleTypeKind edmSimpleType = EdmSimpleTypeKind.BOOLEAN;
  
  @Override
  public boolean equals(Object obj) {
    boolean equals = false;
    if (this == obj) {
      equals = true;
    } else if (obj instanceof EdmBoolean) {
      equals = true;
    }

    return equals;
  }
  
  @Override
  public String getNamespace() throws EdmException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public EdmTypeKind getKind() {
    return EdmTypeKind.SIMPLE;
  }

  @Override
  public String getName() throws EdmException {
    return this.getTypeRepresentation().getName();
  }

  @Override
  public boolean isCompatible(EdmSimpleType simpleType) {
    boolean compatible;
    
    switch (simpleType.getTypeRepresentation()) {
    case BIT:
    case BOOLEAN:
      compatible = true;
      break;

    default:
      compatible = false;
      break;
    }
      
    return compatible;
  }

  @Override
  public boolean validate(String value, EdmLiteralKind literalKind, EdmFacets facets) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object valueOfString(String value, EdmLiteralKind literalKind, EdmFacets facets) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String valueToString(Object value, EdmLiteralKind literalKind, EdmFacets facets) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toUriLiteral(String literal) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public EdmSimpleTypeKind getTypeRepresentation() {
    return edmSimpleType;
  }

}