package com.mexhee.tcp.connection;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.mexhee.tcp.packet.TCPPacket;

public class PacketsBuffer {

	/**
	 * store the data packets (client to server) that cannot match seq number
	 * due to captured in incorrect sequence
	 */
	SortedSet<TCPPacket> csTemporaryStoredPackets = new TreeSet<TCPPacket>();
	/**
	 * store the data packets (server to client) that cannot match seq number
	 * due to captured in incorrect sequence
	 */
	SortedSet<TCPPacket> scTemporaryStoredPackets = new TreeSet<TCPPacket>();

	private TCPConnection connection;

	public PacketsBuffer(TCPConnection connection) {
		this.connection = connection;
	}

	void addToCSTemporaryStoredDataPackets(TCPPacket packet) {
		csTemporaryStoredPackets.add(packet);
	}

	void addToSCTemporaryStoredDataPackets(TCPPacket packet) {
		scTemporaryStoredPackets.add(packet);
	}

	TCPPacket pickupPacket() {
		TCPPacket packet = pickupCSBuffer();
		if (packet != null) {
			return packet;
		} else {
			return pickupSCBuffer();
		}
	}

	boolean isStillHaveDataPacketsInCSBuffer() {
		return hasDataPackets(csTemporaryStoredPackets);
	}

	boolean isStillHaveDataPacketsInSCBuffer() {
		return hasDataPackets(scTemporaryStoredPackets);
	}

	private boolean hasDataPackets(SortedSet<TCPPacket> buffer) {
		Iterator<TCPPacket> it = buffer.iterator();
		while (it.hasNext()) {
			if (it.next().isContainsData()) {
				return true;
			}
		}
		return false;
	}

	private TCPPacket pickupCSBuffer() {
		if (!csTemporaryStoredPackets.isEmpty()) {
			TCPPacket packet = csTemporaryStoredPackets.first();
			if (connection.isCanProcessPacket(packet)) {
				csTemporaryStoredPackets.remove(packet);
				return packet;
			} else if (connection.isOldPacket(packet)) {
				csTemporaryStoredPackets.remove(packet);
				return pickupCSBuffer();
			}
		}
		return null;
	}

	private TCPPacket pickupSCBuffer() {
		if (!scTemporaryStoredPackets.isEmpty()) {
			TCPPacket packet = scTemporaryStoredPackets.first();
			if (connection.isCanProcessPacket(packet)) {
				scTemporaryStoredPackets.remove(packet);
				return packet;
			} else if (connection.isOldPacket(packet)) {
				scTemporaryStoredPackets.remove(packet);
				return pickupSCBuffer();
			}
		}
		return null;
	}
}
