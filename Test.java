import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Test {
    enum Priority{
   lowerst (1),
   very_low (2),
   lower (3),
    low (4),
    medium(5),
    hight(6),
    highter(7),
   very_hight(8),
    hightest(9);

private int priority;

    Priority(int priority){
        this.priority=priority;
    }
    public int getPriority(){return priority;}

}
Priority priority() default Priority.medium;
}
