#ADAPTER Pattern

As a software developer, you write classes whose methods are called by clients. You may be able to control the interface that the client expects, but often you will not be able to do so. The most common example of an expectation that you must frequently fulfill is the implementation of the main() method that the Java interpreter expects. Services such as Swing also often include features that require you to support a predefined interface.

When you need to implement an expected interface, you may find that an existing class performs the services a client needs but with different method names. You can use the existing class to meet the client's needs by applying the ADAPTER pattern. The intent of ADAPTER is to provide the interface a client expects, using the services of a class with a different interface.
