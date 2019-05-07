package com.mycompany.desafio.api.base.conf;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * Classe responsÃ¡vel por utilizar a strategia de conversÃ£o de Camel Case para underscore
 *
 * @author ruan
 */
public class CamelCaseImproveStrategy extends org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy implements Serializable {

  private static final long serialVersionUID = -3684947602685100085L;

  /**
   * Formata o Nome que queremos
   * 
   * @param prefixo Prefixo para ser posto na nomenclatura
   * @param identifier Identificador
   * @return Valor formatado conforme parametros
   */
  private String formatName(final String prefixo, final Identifier identifier) {
    if (StringUtils.contains(identifier.getText(), prefixo)) {
      return identifier.getText().toLowerCase();
    }

    final StringBuilder retorno = new StringBuilder(StringUtils.isEmpty(prefixo) ? "" : prefixo);

    retorno.append(identifier.getText());

    return retorno.toString().replaceAll("([^_A-Z])([A-Z])", "$1_$2").toLowerCase();
  }
  
  public String formatName(final String prefixo, String identifier) {
	    if (StringUtils.contains(identifier, prefixo)) {
	      return identifier.toLowerCase();
	    }

	    final StringBuilder retorno = new StringBuilder(StringUtils.isEmpty(prefixo) ? "" : prefixo);

	    retorno.append(identifier);

	    return retorno.toString().replaceAll("([^_A-Z])([A-Z])", "$1_$2").toLowerCase();
	  }

  @Override
  public Identifier toPhysicalColumnName(final Identifier name, final JdbcEnvironment context) {
    return new Identifier(this.formatName(null, name), name.isQuoted());
  }


  @Override
  public Identifier toPhysicalTableName(final Identifier name, final JdbcEnvironment context) {
    return new Identifier(this.formatName(AppConstants.TABLE_PREFIX, name), name.isQuoted());
  }

}
