package jpcap;

import jpcap.packet.Packet;

/** This class is used to send a packet. */
public class JpcapSender extends JpcapInstance {
	private native String nativeOpenDevice(String device);
	private native void nativeSendPacket(Packet packet);
	private native void nativeCloseDevice();
	private native void nativeOpenRawSocket();
	private native void nativeSendPacketViaRawSocket(Packet packet);
	private native void nativeCloseRawSocket();
	
	private static final int RAW_SOCKET_ID=99999;

	private JpcapSender() throws java.io.IOException {
		if (reserveID() < 0)
			throw new java.io.IOException("Unable to open a device: "
					+ MAX_NUMBER_OF_INSTANCE + " devices are already opened.");
	}
	
	JpcapSender(int ID){
		this.ID=ID;
	}

	/**
	 * Initializes a network interface for sending a packet, and returns an
	 * instance of this class.
	 * 
	 * @param device
	 *            Interface for sending a packet
	 * @throws IOException
	 *             Raised when initialization of the interface failed
	 * @return intstance of this class (JpcapSender)
	 */
	public static JpcapSender openDevice(NetworkInterface device) throws java.io.IOException {
		JpcapSender sender = new JpcapSender();
		String ret=sender.nativeOpenDevice(device.name);

		if(ret==null)
			return sender;
		else
			throw new java.io.IOException(ret);
	}

	/**
	 * Open a raw IP socket to send a packet.<BR>
	 * When sending a packet via a raw socket, the datalink header of the packet is ignored
	 * (= automatically generated by OS).<P>
	 * Note: the implementation and behavior of a raw socket may vary in different OS.
	 * Also, you can only open one raw socket at a time.
	 * 
	 * @throws IOException
	 *             Raised when initialization of the interface failed
	 * @return intstance of this class (JpcapSender)
	 */
	@Deprecated
	public static JpcapSender openRawSocket() throws java.io.IOException {
		JpcapSender sender = new JpcapSender();
		sender.nativeOpenRawSocket();
		sender.ID=RAW_SOCKET_ID;
		
		return sender;
	}

	/** Closes the interface. */
	public void close() {
		if(ID==RAW_SOCKET_ID)
			nativeCloseRawSocket();
		else
			nativeCloseDevice();
		unreserveID();
	}

	/**
	 * Sends a packet.
	 * <P>
	 * If this JpcapSender instance was created by openDevice(), you need to set
	 * the Datalink layer's header (e.g., Ethernet header) of the packet. <P>
	 * 
	 * If this JpcapSender instance was created by openRawSocket(), you can only
	 * send IP packets, but you may not need to set the Datalink layer's header
	 * of the IP packets you want to send.<BR>
	 * Note: the implementation and behavior of a raw socket may vary in different OS.
	 * For example, in Windows 2000/XP, you need to manually set the datalink/IP headers
	 * of a packet. 
	 * @param packet Packet to be sent
	 */
	public void sendPacket(Packet packet){
		if(ID==RAW_SOCKET_ID)
			nativeSendPacketViaRawSocket(packet);
		else
			nativeSendPacket(packet);
	}
}
