public class Mountain<T>{
    private String name;
    private Integer MElevation;
    private Integer FtElevation;
    private String range;
    private String location;
    private Mountain<T> left;
    private Mountain<T> right;

    Mountain(String name){
        this.name = name;
    }

    Mountain(String name, Integer MElevation, Integer FtElevation, String range, String location){
        this.name = name;
        this.MElevation = MElevation;
        this.FtElevation = FtElevation;
        this.range = range;
        this.location = location;
        left = right = null;
    }

    public void setLeft(Mountain<T> left) {this.left=left;}

    public void setRight(Mountain<T> right) {this.right=right;}

    public Mountain<T> getLeft(){
        return left;
    }

    public Mountain<T> getRight(){
        return right;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setMElevation(Integer MElevation){
        this.MElevation = MElevation;
    }

    public Integer getMElevation() {
        return MElevation;
    }

    public void setFtElevation(Integer FtElevation){
        this.FtElevation = FtElevation;
    }

    public Integer getFtElevation() {
        return FtElevation;
    }

    public void setRange(String range){
        this.range = range;
    }
    public String getRange() {
        return range;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString(){
        return "Mountain: " + name + ' ' + "Elevation(meters): " + MElevation + ' ' +
               "Elevation(feet): " + FtElevation + ' ' + " Mountain Range: "+ range + ' '
                + "Location: " + location;
    }

    public boolean equals(Mountain<T> mountain){
        if (MElevation.equals(mountain.getMElevation())){
            if (FtElevation.equals(mountain.getFtElevation())){
                return true;
            }
        }
        return false;
    }

    public int compareTo(Mountain<T> mountain){
        if(MElevation - (mountain.getMElevation()) == 0){
            return FtElevation - (mountain.getFtElevation());
        }
        return MElevation - (mountain.getMElevation());
    }

}
