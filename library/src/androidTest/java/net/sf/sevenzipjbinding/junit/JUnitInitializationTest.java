package net.sf.sevenzipjbinding.junit;

import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipNativeInitializationException;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Tests initialization of SevenZipJBinding
 * 
 * @author Boris Brodski
 * @since 4.65-1
 */
public class JUnitInitializationTest extends JUnitNativeTestBase {

    /**
     * Tests standard initialization of SevenZipJBinding by the base class for all JUnit tests.
     */
    @Test
    public void initializationTest() {
        assertTrue("SevenZip wasn't initialized by base class " + this.getClass().getSuperclass().getCanonicalName(),
                SevenZip.isInitializedSuccessfully());
    }

    /**
     * After SevenZipJBinding was initialized by the base class {@link JUnitNativeTestBase} another call to any of
     * initialization routines should return no exception.
     * 
     * @throws SevenZipNativeInitializationException
     *             throws, if SevenZipJBinding will proceed with the initialization and it's will fail.
     */
    @Test
    public void doubleInitializationTest() throws SevenZipNativeInitializationException {
        SevenZip.initSevenZipFromPlatformJAR("PlatformThatDoesNotExist");
        SevenZip.initSevenZipFromPlatformJAR();
        SevenZip.initSevenZipFromPlatformJAR(new File("DirectoryThatDoesNotExists"));
    }
}
