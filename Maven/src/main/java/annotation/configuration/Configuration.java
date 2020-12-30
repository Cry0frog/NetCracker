package annotation.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Configuration {
    String[] packages() default {"sort.exsample.sortidcontract.SortIdContract", "validators.exsample.addinformvalidator.AddInformValidator", "validators.exsample.agevalidator.AgeValidator", "validators.exsample.datevalidator.DateValidator", "validators.exsample.namevalidator.NameValidator"};
}
