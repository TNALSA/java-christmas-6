package domain.constants;

public enum Badge {
    NONE("없음", 5000),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String grade;
    private final int limit;
    Badge(String grade, int limit){
        this.grade = grade;
        this.limit = limit;
    }

    public String getGrade() {
        return grade;
    }

    public int getLimit() {
        return limit;
    }
}
