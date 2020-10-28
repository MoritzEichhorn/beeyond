package template.field;

import com.intuit.karate.junit5.Karate;

public class TemplateFieldTest {

    @Karate.Test
    Karate testLabelLength() {
        return Karate.run("template-field-post").tags("labelLength").relativeTo(getClass());
    }

    @Karate.Test
    Karate testWildcardLength() {
        return Karate.run("template-field-post").tags("wildcardLength").relativeTo(getClass());
    }

    @Karate.Test
    Karate testDescriptionLength() {
        return Karate.run("template-field-post").tags("descriptionLength").relativeTo(getClass());
    }

    @Karate.Test
    Karate testFieldNotInContent() {
        return Karate.run("template-field-post").tags("fieldNotInContent").relativeTo(getClass());
    }
}
