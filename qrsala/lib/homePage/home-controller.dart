import 'dart:async';

import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:qrsala/rest/sala-service.dart';
import 'package:qrsala/salaPage/sala-widget.dart';
import 'package:rxdart/rxdart.dart';

import 'package:flutter/material.dart';
import 'package:barcode_scan/barcode_scan.dart';
import 'package:flutter/services.dart';

class HomeController implements BlocBase {
  @override
  BuildContext context;

  SalaService _salaService = SalaService();

  HomeController() {
    listarSalas();
  }

  @override
  void dispose() {
    _streamSalas.close();
  }

  var _streamSalas = BehaviorSubject<List<dynamic>>(seedValue: List<dynamic>());

  Stream<List<dynamic>> get outSalas => _streamSalas.stream;

  String result = "QRCode";

  Future scanQR() async {
    try {
      String qrResult = await BarcodeScanner.scan();

      result = qrResult;
    } on PlatformException catch (ex) {
      if (ex.code == BarcodeScanner.CameraAccessDenied) {
        // Mensagem câmera necessária
      }
    } on FormatException {} catch (ex) {}
  }

  listarSalas() async {
    await _salaService.obterDistinctSemana().then((data) {
      _streamSalas.value = data;
    }, onError: (error) {});
  }

  telaSala(int nome) {
    Navigator.push(
        context,
        new MaterialPageRoute(
          builder: (BuildContext context) =>
              new SalaPage(nome),
        ));
  }
}
