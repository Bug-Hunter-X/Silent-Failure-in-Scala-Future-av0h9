# Silent Failure in Scala Future

This example demonstrates a common error in Scala: unhandled exceptions within Futures.  The `myMethod` function throws an exception when `i` is 0.  Without proper error handling, this exception will be swallowed and the caller won't receive any indication of failure.  The solution below addresses this issue.

This is crucial in production systems, as silent failures can be difficult to diagnose.  Always ensure that your Futures are properly handled and any potential exceptions are caught.