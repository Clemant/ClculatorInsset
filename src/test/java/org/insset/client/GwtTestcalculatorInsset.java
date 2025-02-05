package org.insset.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import org.insset.client.service.ExempleService;
import org.insset.client.service.ExempleServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase. Using
 * <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 */
public class GwtTestcalculatorInsset extends GWTTestCase {

//     Must refer to a valid module that sources this class.
     
    public String getModuleName() {
        return "org.insset.calculatorInssetJUnit";
    }

//     Tests the FieldVerifier.
    
    public void testFieldVerifier() {
        assertFalse(FieldVerifier.isValidName(null));
        assertFalse(FieldVerifier.isValidName(""));
        assertTrue(FieldVerifier.isValidName("a"));
        assertTrue(FieldVerifier.isValidName("ab"));
        assertTrue(FieldVerifier.isValidName("abc"));
        assertTrue(FieldVerifier.isValidName("abcd"));
    }

    /**
     * This test will send a request to the server using the greetServer method
     * in GreetingService and verify the response.
     */
    public void testExempleService() {
        // Create the service that we will test.
        ExempleServiceAsync exempleService = GWT.create(ExempleService.class);
        ServiceDefTarget target = (ServiceDefTarget) exempleService;
        target.setServiceEntryPoint(GWT.getModuleBaseURL() + "calculatorInsset/exemple");

        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        // Send a request to the server.
        exempleService.inverserChaine("User", new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // The request resulted in an unexpected error.
                fail("Request failure: " + caught.getMessage());
            }

            public void onSuccess(String result) {
                // Verify that the response is correct.
                assertTrue(result.startsWith("resU"));

                // Now that we have received a response, we need to tell the test runner
                // that the test is complete. You must call finishTest() after an
                // asynchronous test finishes successfully, or the test will time out.
                finishTest();
            }
        });
    }
}