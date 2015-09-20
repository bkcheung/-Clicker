/* Copyright 2011-2013 Google Inc.
 * Copyright 2013 mike wakerly <opensource@hoho.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * Project home page: https://github.com/mik3y/usb-serial-for-android
 */

package src.com.hoho.android.usbserial.examples;

import java.io.IOException;


import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import java.io.IOException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.examples.R;
import com.hoho.android.usbserial.util.HexDump;
import com.hoho.android.usbserial.util.SerialInputOutputManager;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Monitors a single {@link UsbSerialPort} instance, showing all data
 * received.
 *
 * @author mike wakerly (opensource@hoho.com)
 */
public class SerialConsoleActivity extends Activity {

    private final String TAG = SerialConsoleActivity.class.getSimpleName();

    /**
     * Driver instance, passed in statically via
     * {@link #show(Context, UsbSerialPort)}.
     *
     * <p/>
     * This is a devious hack; it'd be cleaner to re-create the driver using
     * arguments passed in with the {@link #startActivity(Intent)} intent. We
     * can get away with it because both activities will run in the same
     * process, and this is a simple demo.
     */
    private static UsbSerialPort sPort = null;
    private UsbSerialPort port;
    //private TextView mTitleTextView;
//    private TextView mDumpTextView;
//    private ScrollView mScrollView;

    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    private SerialInputOutputManager mSerialIoManager;

    private final SerialInputOutputManager.Listener mListener =
            new SerialInputOutputManager.Listener() {

        @Override
        public void onRunError(Exception e) {
            Log.d(TAG, "Runner stopped.");
        }

        @Override
        public void onNewData(final byte[] data) {
            SerialConsoleActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SerialConsoleActivity.this.updateReceivedData(data);
                }
            });
        }
};

@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serial_console);
  //      mTitleTextView = (TextView) findViewById(R.id.title);
//        mDumpTextView = (TextView) findViewById(R.id.consoleText);
//        mScrollView = (ScrollView) findViewById(R.id.demoScroller);

        Button button = (Button) findViewById(R.id.one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] bob = new byte[1];
                bob[0]=(byte)0xe0;
                try {
                    sPort.write(bob, 1000);
                }
                catch(IOException a){}
            }

        });
                        Button button2 = (Button) findViewById(R.id.two);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe1;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });
                    Button button3 = (Button) findViewById(R.id.three);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe2;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });
                    Button button4 = (Button) findViewById(R.id.four);
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe3;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });
                    Button button5 = (Button) findViewById(R.id.five);
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe4;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button6 = (Button) findViewById(R.id.six);
                    button6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe5;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button7 = (Button) findViewById(R.id.seven);
                    button7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe6;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button8 = (Button) findViewById(R.id.eight);
                    button8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe7;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button9 = (Button) findViewById(R.id.nine);
                    button9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe8;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button10 = (Button) findViewById(R.id.ten);
                    button10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xe9;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });

                    Button button11 = (Button) findViewById(R.id.eleven);
                    button11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            byte[] bob = new byte[1];
                            bob[0]=(byte)0xeA;
                            try {
                                sPort.write(bob, 1000);
                            }
                            catch(IOException a){}
                        }
                    });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopIoManager();
        if (sPort != null) {
            try {
                sPort.close();
            } catch (IOException e) {
                // Ignore.
            }
            sPort = null;
        }
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resumed, port=" + sPort);
        if (sPort == null) {
      //     mTitleTextView.setText("No serial device.");
        } else {
            final UsbManager usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);

            UsbDeviceConnection connection = usbManager.openDevice(sPort.getDriver().getDevice());
            if (connection == null) {
                //mTitleTextView.setText("Opening device failed");
                return;
            }

            try {
                sPort.open(connection);
                sPort.setParameters(1200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
            } catch (IOException e) {
                Log.e(TAG, "Error setting up device: " + e.getMessage(), e);
                //mTitleTextView.setText("Error opening device: " + e.getMessage());
                try {
                    sPort.close();
                } catch (IOException e2) {
                    // Ignore.
                }
                sPort = null;
                return;
            }
            //mTitleTextView.setText("Serial device: " + sPort.getClass().getSimpleName());
        }
        onDeviceStateChange();
    }

    private void stopIoManager() {
        if (mSerialIoManager != null) {
            Log.i(TAG, "Stopping io manager ..");
            mSerialIoManager.stop();
            mSerialIoManager = null;
        }
    }

    private void startIoManager() {
        if (sPort != null) {
            Log.i(TAG, "Starting io manager ..");
            mSerialIoManager = new SerialInputOutputManager(sPort, mListener);
            mExecutor.submit(mSerialIoManager);
        }
    }

    private void onDeviceStateChange() {
        stopIoManager();
        startIoManager();
    }

    private void updateReceivedData(byte[] data) {
        final String message = "Read " + data.length + " bytes: \n"
                + HexDump.dumpHexString(data) + "\n\n";
//        mDumpTextView.append(message);
//        mScrollView.smoothScrollTo(0, mDumpTextView.getBottom());
    }

    /**
     * Starts the activity, using the supplied driver instance.
     *
     * @param context
//     * @param driver
     */
    static void show(Context context, UsbSerialPort port) {
        sPort = port;
        final Intent intent = new Intent(context, SerialConsoleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }

}
