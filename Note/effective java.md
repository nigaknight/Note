# 1 Creating and Destroying Objects

## Item 1 Considering static factory methods instead of constructors

The traditional way to create a instance: public constructors.

The better way: static factory methods, return class instance.

**Advantages:**

**1.the static factory methods have names**

example code:

```java
public static Boolean valueOf(boolean b){
    return b? Boolean.True: Boolean.False;
}
```

example for comparison:

```java
BigInteger(int, int ,Random)
```

the constructor return a probably prime big integer

the better way:

```java
BigInteger.probablePrime
```

 another advantage: the same signature constructor is not allowed, the static factory method can solve the problem.

**2.the static factory methods are not required to create a new object each time they're invoked**

reuse previous constructed objects 

1) return the same object from repeated invocation -> instance-controlled classes -> singleton, non-instantiate

2) no two equal instances exist -> a.equals(b) if and only if a == b

**3.the static factory methods return an object of any subtype of their return type**

1) return objects without making their class public 

example: Java.util.Collections

2) Prior to Java 8: static methods for an interface are not allowed, the implementations are exported via static factory methods in a non-instantiate class, the classes of the return type are all private.

Java 8: public static methods for an interface are allowed

Java 9: private static methods for an interface are allowed, static fields and member classes are not allowed

**4.the class of return object can vary as a function of the input parameters**

example: EnumSet

**5.the class of the return object need not exist**

service provider framework, example: JDBC( Java Database Connectivity API)

service interface, provider registration API, service access API

**Limitations:**

**1.the class without protected or public constructor cannot be subclasses**

**2.hard for programmers to find**

read documents of a class, you should pay attention to static methods and the common naming conventions

common naming conventions:

1) from, of, valueOf

2) instance(getInstance), create(newInstance)

3) getType, newType, type (the Type is the type of return object, used the factory method is in a different class )