package com.jdf.swing.helper.jtable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation respons�vel pela marca��o de metadados
 * para exibi��o em componentes JTable
 * @author lossurdo
 * @since 22/03/2009
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JTableColumnMetadata {
    /**
     * Nome do cabe�alho da coluna
     * @return
     */
    public String name();
    /**
     * Tamanho em pixels para a coluna
     * @return
     */
    public int size() default 0;
    
    /**
     * Formato em que os dados ser�o exibidos
     * @return
     */
	public ColumnMetadataFormat format() default ColumnMetadataFormat.DEFAULT;
	
	/**
	 * Alinhamento em que os dados ser�o exibidos
	 * @return
	 */
	public ColumnMetadataAlign align() default ColumnMetadataAlign.LEFT;
}
