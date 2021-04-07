package Day10;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 07
 * Time:21:13
 */
public enum ColourType {
    ColourType_R(10,"红"),
    ColourType_B(20,"蓝"),
    ColourType_G(110,"绿"),
    ColourType_Y(1100,"黄");

    private Integer id;
    private String name;

    ColourType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String findName(Integer Id) {
        ColourType[] tyList = ColourType.values();
        for (int i = 0; i < tyList.length; i++) {
            //错误代码如下：
            //if(tyList[i] != null && tyList[i].id==Id))
            //这里不能使用==来进行比较，因为如果数值x>128或x<-127,就会new一个对象来存储
            //==比较的是地址，所以不会正常输出
            if(tyList[i] != null && tyList[i].id.equals(Id)){
                return tyList[i].name;
            }
        }
        return "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Integer idB = 20;
        System.out.println(ColourType.findName(idB));
        Integer idG = 110;
        System.out.println(ColourType.findName(idG));
        Integer idY = 1100;
        System.out.println(ColourType.findName(idY));
    }
}
