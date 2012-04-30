package com.mexhee.packet.util;

import java.io.File;
import java.io.IOException;

import jpcap.JpcapCaptor;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mexhee.tcp.connection.ViewTCPConnection;
import com.mexhee.tcp.connection.listener.ConnectionFilter;

public class TCPPacketsRecorderTest {
	private static String dumpFolder = "";

	@BeforeClass
	public static void setup() {
		dumpFolder = new File("test/dump").getAbsolutePath();
		System.out.println(dumpFolder);
	}

	public void testDumpFile() throws IOException {
		ConnectionFilter filter = new ConnectionFilter();
		filter.addServerHostFilter("192.168.1.1");
		TCPPacketsRecorder recorder = new TCPPacketsRecorder(filter, JpcapCaptor.getDeviceList()[0], dumpFolder);
		recorder.start();
	}

	public void testRunAppFromDumpFile() throws IOException, ClassNotFoundException {
		TCPPacketsRecorder.open(dumpFolder + "/192.168.1.100(4606)-192.168.1.1(80)_1162393258000.dump",
				new ViewTCPConnection());
	}

	@Test
	public void testRunAppFromDumpFolder() throws IOException, ClassNotFoundException {
		TCPPacketsRecorder.scan(dumpFolder, new ViewTCPConnection());
	}

	public void testViewPacketsFromDumpFile() throws IOException, ClassNotFoundException {
		TCPPacketsRecorder.open(dumpFolder + "/192.168.1.100(2350)-192.168.1.1(80)_1334495098578.dump",
				new ViewTCPConnection());
	}
}