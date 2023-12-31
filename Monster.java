package Monster_Maker;

import java.lang.reflect.Field;
import java.util.*;

public class Monster {
    String colorOfEye;
    String featherColor;
    boolean magicalability;
    int size;
    int strength;
    int durability;
    int agressionLevel;
    HashMap<String,Object> additionalAttribute = new HashMap<>();

    public Object getAdditionalAttribute(String attributeName) {
        return additionalAttribute.get(attributeName);
    }

    public void setAdditionalAttribute(String attributeName,Object attributeValue) {
        additionalAttribute.put(attributeName,attributeValue);
    }

    public Monster() {

    }

    @Override
    public String toString() {
        return  "colorOfEye='" + colorOfEye + '\'' +
                ", featherColor='" + featherColor + '\'' +
                ", magicalability=" + magicalability +
                ", size=" + size +
                ", strength=" + strength +
                ", durability=" + durability +
                ", agressionLevel=" + agressionLevel +
                ", additionalAttribute=" + additionalAttribute;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster monster)) return false;
        return magicalability == monster.magicalability && size == monster.size && strength == monster.strength && durability == monster.durability && agressionLevel == monster.agressionLevel && Objects.equals(colorOfEye, monster.colorOfEye) && Objects.equals(featherColor, monster.featherColor) && Objects.equals(additionalAttribute, monster.additionalAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorOfEye, featherColor, magicalability, size, strength, durability, agressionLevel,additionalAttribute);
    }

    public Monster(String colorOfEye, String featherColor, boolean magicalability, int size, int strength, int durability, int agressionLevel) {
        this.colorOfEye = colorOfEye;
        this.featherColor = featherColor;
        this.magicalability = magicalability;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.agressionLevel = agressionLevel;
    }
    static Set<Monster> createBaby(Set<Monster> monsterSet){
        Set<Monster> babyMonsterSet = new HashSet<Monster>();
        List<Monster> monsterList = new ArrayList<>(monsterSet);
        for(int i=0;i<monsterSet.size();i++)
        {
            for(int j=i+1;j< monsterSet.size();j++)
            {
                Monster m1 = monsterList.get(i);
                Monster m2 = monsterList.get(j);
                Random random = new Random();
                String colorOfEye = random.nextBoolean()?m1.colorOfEye:m2.colorOfEye;
                String featherColor = random.nextBoolean()?m1.featherColor:m2.featherColor;
                boolean magicalability = random.nextBoolean()?m1.magicalability:m2.magicalability;
                int size = random.nextBoolean()?m1.size:m2.size;
                int strength = random.nextBoolean()?m1.strength:m2.strength;
                int durability = random.nextBoolean()?m1.durability:m2.durability;
                int agressionLevel = random.nextBoolean()?m1.agressionLevel:m2.agressionLevel;
                Monster babyMonster = new Monster(colorOfEye, featherColor, magicalability, size, strength, durability, agressionLevel);
                babyMonsterSet.add(babyMonster);
            }
        }
        return babyMonsterSet;
    }

    /*public void addAttribute(String attributeName,Object attributValue){
        try{
            Field field = getClass().getDeclaredField(attributeName);
            field.setAccessible(true);
            field.set(this,attributValue);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
    public void displayAtrribute()  {
        Field[] fields = getClass().getDeclaredFields();
        for (Field field:fields)
        {
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }
}
