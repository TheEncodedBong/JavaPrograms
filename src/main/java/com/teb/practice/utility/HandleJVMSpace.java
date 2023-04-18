package com.teb.practice.utility;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class HandleJVMSpace {

	private static void getRuntimeData() {

		/* Total memory available to JVM */
		System.out.println(Runtime.getRuntime().totalMemory());

		/* Maximum memory JVM tries to use */
		System.out.println(Runtime.getRuntime().maxMemory());

		/* Free memory available to JVM */
		System.out.println(Runtime.getRuntime().freeMemory());

		/* Garbage collection */
		Runtime.getRuntime().gc();
	}

	private static void getMXHeapData() {

		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

		/* Total memory available to JVM */
		System.out.println(memoryBean.getHeapMemoryUsage().getInit());

		/* Maximum memory JVM tries to use */
		System.out.println(memoryBean.getHeapMemoryUsage().getMax());

		/* Guaranteed memory available to JVM */
		System.out.println(memoryBean.getHeapMemoryUsage().getCommitted());

		/* Memory used by JVM */
		System.out.println(memoryBean.getHeapMemoryUsage().getUsed());
	}

	private static void getMXNonHeapData() {

		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

		/* Total memory available to JVM */
		System.out.println(memoryBean.getNonHeapMemoryUsage().getInit());

		/* Maximum memory JVM tries to use */
		System.out.println(memoryBean.getNonHeapMemoryUsage().getMax());

		/* Guaranteed memory available to JVM */
		System.out.println(memoryBean.getNonHeapMemoryUsage().getCommitted());

		/* Memory used by JVM */
		System.out.println(memoryBean.getNonHeapMemoryUsage().getUsed());
	}

	public static void main(String[] args) {

		System.out.println("\nJVM heap space details using Runtime class");
		getRuntimeData();

		System.out.println("\nJVM heap space details using MemoryMXBean class");
		getMXHeapData();

		System.out.println("\nJVM non-heap space details using MemoryMXBean class");
		getMXNonHeapData();
	}

}
