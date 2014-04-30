package com.alipay.hbaseviewer.ext.consumerecord;

import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import com.alipay.hbaseviewer.ext.DisplayOnlyStringRowKey;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.rowkey.handler.RowKeyHandler;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;

public class ConsumeRecordBizInNoRowKeyHandler implements RowKeyHandler {

    @Override
    public RowKey convert(byte[] row) {
        StringBuilder sb = new StringBuilder();
        List<byte[]> list = BytesUtil.split(row, BytesUtil.ZERO);
        Util.check(list.size() == 3);

        sb.append(StringUtil.reverse(Bytes.toString(list.get(0))));
        sb.append(" ");

        sb.append(Bytes.toString(list.get(1)));
        sb.append(" ");

        sb.append(Bytes.toString(list.get(2)));

        return new DisplayOnlyStringRowKey(sb.toString());
    }
}
