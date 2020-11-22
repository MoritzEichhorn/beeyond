package at.htl.beeyond.intergration.application;

import at.htl.beeyond.intergration.DatabaseResource;
import at.htl.beeyond.intergration.IdentityProviderResource;
import com.intuit.karate.junit5.Karate;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(DatabaseResource.class)
@QuarkusTestResource(IdentityProviderResource.class)
public class ApplicationTest {

    @Karate.Test
    Karate testGetAllAsTeacher() {
        return Karate.run("application-get").tags("teacher").relativeTo(getClass());
    }

    @Karate.Test
    Karate testGetAllAsStudent() {
        return Karate.run("application-get").tags("student").relativeTo(getClass());
    }

    @Karate.Test
    Karate testApproveAsTeacher() {
        return Karate.run("application-approve").tags("teacher").relativeTo(getClass());
    }

    @Karate.Test
    Karate testApproveAsStudent() {
        return Karate.run("application-approve").tags("student").relativeTo(getClass());
    }

    @Karate.Test
    Karate testDenyAsTeacher() {
        return Karate.run("application-deny").tags("teacher").relativeTo(getClass());
    }

    @Karate.Test
    Karate testDenyAsStudent() {
        return Karate.run("application-deny").tags("teacher").relativeTo(getClass());
    }
}
