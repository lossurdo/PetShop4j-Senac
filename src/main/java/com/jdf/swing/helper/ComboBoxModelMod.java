package com.jdf.swing.helper;

import com.jdf.swing.helper.jtable.JTableAssist;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * Classe responsável pela estrutura de dados utilizada pelo componente
 * JComboBoxHelper
 *
 * @author lossurdo
 * @since 12/03/2009
 */
@SuppressWarnings("unchecked")
class ComboBoxModelMod<T> implements ComboBoxModel {

    private List<T> list;
    private Object sel;

    /**
     * Construtor
     *
     * @param list Listagem de objetos
     */
    public ComboBoxModelMod(List<T> list) {
        this.list = list;
    }

    @Override
    public Object getSelectedItem() {
        return sel;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.sel = anItem;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public Object getElementAt(int index) {
        T elm = list.get(index);
        Field[] attr = elm.getClass().getDeclaredFields();
        for (Field f : attr) {
            if (JTableAssist.isAnnotated(f) && JTableAssist.isValue(f)) {
                try {
                    return elm.getClass().getMethod("get" + JTableAssist.capitalize(f.getName()), null).invoke(elm, null);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return elm;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

}
