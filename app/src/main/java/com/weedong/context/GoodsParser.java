package com.weedong.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

public class GoodsParser {
	static final String GOODS_EXT_ID = "goods_ext_id";
	static final String GOODS_NAME = "goods_name";
	static final String BASE_ITEM = "item";
	static final String PROPERTY_ITEM = "item";
	private Context context;

	public GoodsParser(Context context) {
		this.context = context;
	}

	public List<ItemModel> parse() {
		final List<ItemModel> lsGoods = new ArrayList<ItemModel>();
		final ItemModel currentItemModel = new ItemModel();
		RootElement root = new RootElement("data");
		Element item = root.getChild(BASE_ITEM);
		item.setEndElementListener(new EndElementListener() {
			public void end() {
				lsGoods.add(currentItemModel);
			}
		});
		item.getChild(GOODS_NAME).setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentItemModel.setGoods_name(body);
					}
				});

		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lsGoods;
	}
	
	private InputStream getInputStream() throws IOException {
		return context.getResources().getAssets().open("file/base_goods1.xml");
	}

}
