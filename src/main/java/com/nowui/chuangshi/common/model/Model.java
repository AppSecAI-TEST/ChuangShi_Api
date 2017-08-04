package com.nowui.chuangshi.common.model;

import com.jfinal.plugin.activerecord.Table;
import com.jfinal.plugin.activerecord.TableMapping;
import com.nowui.chuangshi.common.annotation.Column;
import com.nowui.chuangshi.common.sql.Condition;
import com.nowui.chuangshi.common.sql.ConditionType;
import com.nowui.chuangshi.common.sql.Expression;
import com.nowui.chuangshi.common.sql.ExpressionType;
import com.nowui.chuangshi.constant.Constant;
import com.nowui.chuangshi.type.ColumnType;
import com.nowui.chuangshi.util.DateUtil;
import com.nowui.chuangshi.util.ValidateUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class Model<M extends Model> extends com.jfinal.plugin.activerecord.Model<M> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String conditionSql;
    private List<Condition> conditionList = new ArrayList<Condition>();
    private StringBuilder selectSql = new StringBuilder();
    private StringBuilder setSql = new StringBuilder();
    private StringBuilder orderSql = new StringBuilder();
    private StringBuilder paginateSql = new StringBuilder();
    private Boolean isSystemVersion = true;
    private Boolean isSystemStatus = true;
    private List<Map<String, Object>> columnList;

    private void addConditionList(Condition condition) {
        Boolean isExit = false;

        Expression expression = condition.getExpression();
        if (expression != null) {
            for (int i = 0; i < getColumnList().size(); i++) {
                Map<String, Object> column = getColumnList().get(i);

                if (column.get("name").toString().equals(expression.getKey())) {
                    isExit = true;

                    break;
                }
            }
        }

        if (isExit) {
            conditionList.add(condition);
        }
    }

    public Boolean isOnlyCondition(String key) {
        Boolean isExit = false;

        for (Condition condition : conditionList) {
            if (condition.getExpression() != null) {
                if (condition.getExpression().getKey().equals(key)) {
                    isExit = true;
                }
            }
        }

        return isExit;
    }

    private Table getTable() {
        return TableMapping.me().getTable(getUsefulClass());
    }

    private Class<? extends com.jfinal.plugin.activerecord.Model> getUsefulClass() {
        Class c = getClass();
        return c.getName().indexOf("EnhancerByCGLIB") == -1 ? c : c.getSuperclass();
    }

    private List<Map<String, Object>> getColumnList() {
        if (columnList == null) {
            columnList = new ArrayList<Map<String, Object>>();

            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                Column column = field.getAnnotation(Column.class);

                if (column != null) {
                    Map<String, Object> map = new HashMap<String, Object>();

                    try {
                        map.put(Constant.NAME, field.get(Model.class).toString());
                        map.put("type", column.type());
                        map.put("length", column.length());
                        map.put("comment", column.comment());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("IllegalAccessException: " + e);
                    }

                    columnList.add(map);
                }
            }
        }

        return columnList;
    }

    public M select(String... keys) {
        if (keys.length > 0) {
            selectSql = new StringBuilder();

            for (int i = 0; i < keys.length; i++) {
                selectSql.append(keys[i]);

                if (i + 1 < keys.length) {
                    selectSql.append(",\n");
                } else {
                    selectSql.append("\n");
                }
            }
        } else {
            selectSql = new StringBuilder("*\n");
        }

        return (M) this;
    }

    public M findById(String id) {
        System.out.println(getTable());
        where(getTable().getPrimaryKey()[0], id);

        return (M) this;
    }

    public M where(String name) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, get(name));
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M where(String name, Object value) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, value);
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereEmpty(String name) {
        if (!ValidateUtil.isNullOrEmpty(get(name))) {
            where(name);
        }

        return (M) this;
    }

    public M whereLike(String name) {
        Expression expression = new Expression(name, ExpressionType.LIKE, get(name));
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereLike(String name, String value) {
        Expression expression = new Expression(name, ExpressionType.LIKE, value);
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereLeftLike(String name) {
        Expression expression = new Expression(name, ExpressionType.LEFT_LIKE, get(name));
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereLeftLike(String name, String value) {
        Expression expression = new Expression(name, ExpressionType.LEFT_LIKE, value);
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereRightLike(String name) {
        Expression expression = new Expression(name, ExpressionType.RIGHT_LIKE, get(name));
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M whereRightLike(String name, String value) {
        Expression expression = new Expression(name, ExpressionType.RIGHT_LIKE, value);
        Condition condition = new Condition(ConditionType.WHERE, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M and(String name) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, get(name));
        Condition condition = new Condition(ConditionType.AND, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M and(String name, Object value) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, value);
        Condition condition = new Condition(ConditionType.AND, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M andEmpty(String name) {
        if (!ValidateUtil.isNullOrEmpty(get(name))) {
            and(name);
        }

        return (M) this;
    }

    public M or(String name) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, get(name));
        Condition condition = new Condition(ConditionType.OR, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M or(String name, Object value) {
        Expression expression = new Expression(name, ExpressionType.EQUAL, value);
        Condition condition = new Condition(ConditionType.OR, expression, false);
        addConditionList(condition);

        return (M) this;
    }

    public M setUpdate(String name) {
        setSql.append(regexCondition(name, "equal", get(name)));
        setSql.append(",\n");

        return (M) this;
    }

    public M setUpdate(String name, Object value) {
        setSql.append(regexCondition(name, "equal", value));
        setSql.append(",\n");

        return (M) this;
    }

    public M notSystemStatus() {
        isSystemStatus = false;

        return (M) this;
    }

    public M notSystemVersion() {
        isSystemVersion = false;

        return (M) this;
    }

    public M paginate() {
        paginateSql = new StringBuilder();
        paginateSql.append("LIMIT ");
        paginateSql.append(getInt(Constant.LIMIT_M));
        paginateSql.append(", ");
        paginateSql.append(getInt(Constant.LIMIT_N));
        paginateSql.append("\n");

        return (M) this;
    }

    private String regexVariable(ColumnType columnType, Object value) {
        StringBuilder stringBuilder = new StringBuilder();

        if (columnType.equals(ColumnType.TINYINT)) {
            stringBuilder.append((Boolean) value ? 1 : 1);
        } else if (columnType.equals(ColumnType.VARCHAR)) {
            stringBuilder.append("'");
            stringBuilder.append(value);
            stringBuilder.append("'");
        } else if (columnType.equals(ColumnType.TEXT)) {
            stringBuilder.append("'");
            stringBuilder.append(value);
            stringBuilder.append("'");
        } else if (columnType.equals(ColumnType.LONGTEXT)) {
            stringBuilder.append("'");
            stringBuilder.append(value);
            stringBuilder.append("'");
        } else if (columnType.equals(ColumnType.DATETIME)) {
            stringBuilder.append("'");
            stringBuilder.append(DateUtil.getDateTimeString((Date) value));
            stringBuilder.append("'");
        } else {
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    private String regexCondition(String name, String operation, Object value) {
        boolean is_left_like = false;
        boolean is_right_like = false;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        if (operation.equals("like")) {
            stringBuilder.append(" LIKE ");

            is_left_like = true;
            is_right_like = true;
        } else if (operation.equals("left_like")) {
            stringBuilder.append(" LIKE ");

            is_left_like = true;
        } else if (operation.equals("right_like")) {
            stringBuilder.append(" LIKE ");

            is_right_like = true;
        } else {
            stringBuilder.append(" = ");
        }

        if (value instanceof String) {
            stringBuilder.append("'");

            if (is_left_like) {
                stringBuilder.append("%");
            }

            stringBuilder.append(value);

            if (is_right_like) {
                stringBuilder.append("%");
            }

            stringBuilder.append("'");
        } else if (value instanceof Boolean) {
            stringBuilder.append((Boolean) value ? 1 : 0);
        } else if (value instanceof Date) {
            stringBuilder.append("'");
            stringBuilder.append(DateUtil.getDateTimeString((Date) value));
            stringBuilder.append("'");
        } else {
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    private Boolean regexExit(String name) {
        Boolean isExit = false;

        for (int i = 0; i < getColumnList().size(); i++) {
            Map<String, Object> column = getColumnList().get(i);

            if (column.get("name").toString().equals(name)) {
                isExit = true;

                break;
            }
        }

        return isExit;
    }

    public String buildConditionSql() {
        if (!ValidateUtil.isNullOrEmpty(conditionSql)) {
            return conditionSql.toString();
        }

        StringBuilder stringBuilder = new StringBuilder();

        Boolean isWhere = false;
        Boolean isLeftLike = false;
        Boolean isRightike = false;
        
        if (isSystemStatus) {
            Expression expression = new Expression(Constant.SYSTEM_STATUS, ExpressionType.EQUAL, true);
            Condition condition = new Condition(ConditionType.WHERE, expression, false);
            addConditionList(condition);
        }

        for(Condition condition : conditionList) {
            if(condition.getExpression() != null) {
                Expression expression = condition.getExpression();
                if (isWhere) {
                    stringBuilder.append("AND ");
                } else {
                    isWhere = true;
                    stringBuilder.append("WHERE ");
                }
                stringBuilder.append(expression.getKey());
                switch (expression.getExpressionType()) {
                    case EQUAL:
                        stringBuilder.append(" = ");
                        break;
                    case LIKE:
                        isLeftLike = true;
                        isRightike = true;

                        stringBuilder.append(" LIKE ");
                        break;
                    case LEFT_LIKE:
                        isLeftLike = true;

                        break;
                    case RIGHT_LIKE:
                        isRightike = true;

                        break;
                    case LESS_THAN:
                        break;
                    case GREAT_THAN_EQUAL:
                        break;
                    case LESS_THAN_EQUAL:
                        break;
                }

                if (expression.getValue() instanceof String) {
                    stringBuilder.append("'");

                    if (isLeftLike) {
                        stringBuilder.append("%");
                    }

                    stringBuilder.append(expression.getValue());

                    if (isRightike) {
                        stringBuilder.append("%");
                    }

                    stringBuilder.append("'");
                } else if (expression.getValue() instanceof Boolean) {
                    stringBuilder.append((Boolean) expression.getValue() ? 1 : 0);
                } else if (expression.getValue() instanceof Date) {
                    stringBuilder.append("'");
                    stringBuilder.append(DateUtil.getDateTimeString((Date) expression.getValue()));
                    stringBuilder.append("'");
                } else {
                    stringBuilder.append(expression.getValue());
                }
                stringBuilder.append("\n");

            } else if(condition.getExpressionGroup() != null) {

            }
        }

        conditionSql = stringBuilder.toString();

        return conditionSql;
    }

    public String buildCountSql() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT \n");
        stringBuilder.append("COUNT(*) \n");
        stringBuilder.append("FROM ");
        stringBuilder.append(getTable().getName());
        stringBuilder.append(" \n");
        stringBuilder.append(buildConditionSql());

        return stringBuilder.toString();
    }

    public String buildListSql() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT \n");
        stringBuilder.append("*");
        stringBuilder.append("\n");
        stringBuilder.append("FROM ");
        stringBuilder.append(getTable().getName());
        stringBuilder.append(" \n");
        stringBuilder.append(buildConditionSql());
        stringBuilder.append(paginateSql);

        buildConditionSql();

        return stringBuilder.toString();
    }

    public String buildFindSql() {
        if (conditionList.size() == 0) {
            throw new RuntimeException("sql without condition");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT \n");
        stringBuilder.append("*");
        stringBuilder.append("\n");
        stringBuilder.append("FROM ");
        stringBuilder.append(getTable().getName());
        stringBuilder.append(" \n");
        stringBuilder.append(buildConditionSql());
        stringBuilder.append(paginateSql);

        return stringBuilder.toString();
    }

    public String buildSaveSql() {
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder stringBuilder2 = new StringBuilder();
        if (conditionList.size() == 0) {
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append(getTable().getName());
            stringBuilder.append(" ");
            stringBuilder.append("(\n");
            for (int i = 0; i < getColumnList().size(); i++) {
                Map<String, Object> column = getColumnList().get(i);

                stringBuilder.append(column.get("name"));
                if (i + 1 < getColumnList().size()) {
                    stringBuilder.append(",\n");
                } else {
                    stringBuilder.append("\n");
                }

                Boolean isExit = false;
                for (Map.Entry<String, Object> attribute : this.getAttrs().entrySet()) {
                    if (column.get("name").equals(attribute.getKey())) {
                        stringBuilder2.append(regexVariable((ColumnType) column.get("type"), attribute.getValue()));

                        isExit = true;

                        break;
                    }
                }

                if (isExit) {

                } else {
                    if (column.get("type").equals(ColumnType.INT)) {
                        stringBuilder2.append("0");
                    } else if (column.get("type").equals(ColumnType.TINYINT)) {
                        stringBuilder2.append("0");
                    } else if (column.get("type").equals(ColumnType.DECIMAL)) {
                        stringBuilder2.append(BigDecimal.valueOf(0));
                    } else if (column.get("type").equals(ColumnType.DATETIME)) {
                        stringBuilder2.append("'");
                        stringBuilder2.append(DateUtil.getDateTimeString(new Date()));
                        stringBuilder2.append("'");
                    } else {
                        stringBuilder2.append("''");
                    }
                }

                if (i + 1 < getColumnList().size()) {
                    stringBuilder2.append(",\n");
                } else {
                    stringBuilder2.append("\n");
                }
            }
            stringBuilder.append(") VALUES (\n");
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(")\n");
        } else {

        }

        return stringBuilder.toString();
    }

    public String buildUpdateSql() {
        if (conditionList.size() == 0) {
            throw new RuntimeException("sql without condition");
        }

        StringBuilder stringBuilder = new StringBuilder();

        remove(Constant.SYSTEM_CREATE_USER_ID, Constant.SYSTEM_VERSION);

        List<Map<String, Object>> updateColumnList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < getColumnList().size(); i++) {
            Map<String, Object> column = getColumnList().get(i);

            for (Map.Entry<String, Object> attribute : this.getAttrs().entrySet()) {
                if (column.get("name").equals(attribute.getKey())) {
                    column.put("value", attribute.getValue());
                    updateColumnList.add(column);

                    break;
                }
            }

        }

        if (updateColumnList.size() == 0) {
            throw new RuntimeException("sql without set variable");
        }

        stringBuilder.append("UPDATE ");
        stringBuilder.append(getTable().getName());
        stringBuilder.append(" SET\n");
        for (int i = 0; i < updateColumnList.size(); i++) {
            Map<String, Object> column = updateColumnList.get(i);

            stringBuilder.append(column.get("name"));
            stringBuilder.append(" = ");
            stringBuilder.append(regexVariable((ColumnType) column.get("type"), column.get("value")));
            if (i + 1 < updateColumnList.size() || isSystemVersion) {
                stringBuilder.append(",\n");
            } else {
                stringBuilder.append("\n");
            }
        }
        if (isSystemVersion) {
            stringBuilder.append(Constant.SYSTEM_VERSION);
            stringBuilder.append(" = ");
            stringBuilder.append(Constant.SYSTEM_VERSION);
            stringBuilder.append(" + 1\n");
        }
        stringBuilder.append(buildConditionSql());

        return stringBuilder.toString();
    }

    public String buildDeleteSql() {
        if (conditionList.size() == 0) {
            throw new RuntimeException("sql without condition");
        }

        String set = setSql.toString();
        if (set.equals("")) {
            throw new RuntimeException("sql without set variable");
        }

        if (isSystemVersion) {
            setSql.append(Constant.SYSTEM_VERSION);
            setSql.append(" = ");
            setSql.append(Constant.SYSTEM_VERSION);
            setSql.append(" + 1\n");

            set = setSql.toString();
        } else {
            set = set.substring(0, set.length() - 2) + "\n";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("UPDATE ");
        stringBuilder.append(getTable().getName());
        stringBuilder.append(" SET\n");
        stringBuilder.append(set);
        stringBuilder.append(buildConditionSql());

        return stringBuilder.toString();
    }

}