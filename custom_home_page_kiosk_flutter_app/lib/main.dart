import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Phone & SMS Launcher'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: _makePhoneCall,
                child: Text('Make a Phone Call'),
              ),
              ElevatedButton(
                onPressed: _sendSMS,
                child: Text('Send an SMS'),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Future<void> _makePhoneCall() async {
    final Uri phoneUri = Uri(scheme: 'tel', path: '1234567890');
    if (await canLaunchUrl(phoneUri)) {
      await launchUrl(phoneUri);
    } else {
      throw 'Could not launch $phoneUri';
    }
  }

  Future<void> _sendSMS() async {
    final Uri smsUri = Uri(scheme: 'sms', path: '1234567890');
    if (await canLaunchUrl(smsUri)) {
      await launchUrl(smsUri);
    } else {
      throw 'Could not launch $smsUri';
    }
  }
}
