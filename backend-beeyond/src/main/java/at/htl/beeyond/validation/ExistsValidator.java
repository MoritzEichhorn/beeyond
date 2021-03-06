package at.htl.beeyond.validation;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    private Exists exists;

    @Override
    public void initialize(Exists constraintAnnotation) {
        this.exists = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean isValid = JpaOperations.count(this.exists.entity(), this.exists.fieldName(), value) != 0;

        if (!isValid) {
            HibernateConstraintValidatorContext ctx = context.unwrap(HibernateConstraintValidatorContext.class);
            ctx.addMessageParameter("class-name", this.exists.entity().getSimpleName());
            ctx.addMessageParameter("field-name", this.exists.fieldName());
        }

        return isValid;
    }
}
