package cn.neu.jing.entity;

public class TaskType {
    private int typeId;
    private String typeName;

    @Override
    public String toString() {
        return "TaskType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
