package com.sap.core.odata.core.uri.expression;

/*1*/

import com.sap.core.odata.api.edm.EdmType;
import com.sap.core.odata.api.exception.ODataApplicationException;
import com.sap.core.odata.api.uri.expression.CommonExpression;
import com.sap.core.odata.api.uri.expression.ExceptionVisitExpression;
import com.sap.core.odata.api.uri.expression.ExpressionKind;
import com.sap.core.odata.api.uri.expression.ExpressionVisitor;
import com.sap.core.odata.api.uri.expression.UnaryExpression;
import com.sap.core.odata.api.uri.expression.UnaryOperator;

public class UnaryExpressionImpl implements UnaryExpression
{
  private InfoUnaryOperator operatorInfo = null;
  private CommonExpression operand = null;
  private EdmType edmType = null;

  public UnaryExpressionImpl(final InfoUnaryOperator operatorInfo, final CommonExpression operand)
  {
    this.operatorInfo = operatorInfo;
    this.operand = operand;
  }

  @Override
  public ExpressionKind getKind()
  {
    return ExpressionKind.UNARY;
  }

  @Override
  public UnaryOperator getOperator()
  {
    return operatorInfo.operator;
  }

  @Override
  public CommonExpression getOperand()
  {
    return operand;
  }

  @Override
  public EdmType getEdmType()
  {
    return edmType;
  }

  @Override
  public CommonExpression setEdmType(final EdmType edmType)
  {
    this.edmType = edmType;
    return this;
  }

  @Override
  public String getUriLiteral()
  {
    return operatorInfo.getSyntax();
  }

  @Override
  public Object accept(final ExpressionVisitor visitor) throws ExceptionVisitExpression, ODataApplicationException
  {
    Object retOperand = operand.accept(visitor);

    Object ret = visitor.visitUnary(this, operatorInfo.getOperator(), retOperand);
    return ret;
  }

}
