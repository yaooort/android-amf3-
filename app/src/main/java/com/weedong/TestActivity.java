package com.weedong;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.weedong.flex.client.AMFConnection;
import com.weedong.flex.messaging.amf.io.AMF3Deserializer;
import com.weedong.flex.messaging.amf.io.AMF3Serializer;
import com.weedong.flex.messaging.io.ASObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;


public class TestActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			String url = "http://192.168.1.247/admin/c_amfphp/gateway.php";
			String service = "userinfo_api.user_reg_name";
			AMFConnection amfConnection = new AMFConnection();
			ASObject result = null;
			amfConnection.connect(url);
			result = (ASObject) amfConnection.call(service, new Object[] { "", 2 });
			amfConnection.close();
			String name = String.valueOf(((ASObject)result.get("msg")).get("new_name"));
			TextView lblFuck = (TextView) findViewById(R.id.text_amf);
			lblFuck.setText(name);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 进行解码
	 *
	 * @return
	 */
	public Object parseAmf3Msg(byte[] bytes) {
		//http://www.programgo.com/article/371981901/
		AMF3Deserializer amf3Deserializer = null;
		try {
			InputStream sbs = new ByteArrayInputStream(bytes);
			DataInputStream dataInput = new DataInputStream(sbs);
			amf3Deserializer = new AMF3Deserializer(new InflaterInputStream(dataInput));
			Object object = amf3Deserializer.readObject();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (amf3Deserializer != null) {
					amf3Deserializer.close();
				}
			} catch (Exception e2) {
			}
		}
		return null;
	}

	/**
	 * 编码
	 *
	 * @param msg
	 * @return
	 */
	public byte[] encode(Object msg) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			DeflaterOutputStream stream = new DeflaterOutputStream(new DataOutputStream(outputStream));


			AMF3Serializer amf3Serializer = new AMF3Serializer(stream);
			// TODO 是否必要
			amf3Serializer.writeObject(msg);

			stream.finish();
			//outputStream.write("\r\n".getBytes());
			return outputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}


}