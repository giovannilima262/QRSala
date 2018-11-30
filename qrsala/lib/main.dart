import 'package:flutter/material.dart';
import 'package:qrsala/homePage/home-controller.dart';
import 'package:qrsala/homePage/home-widget.dart';
import 'package:bloc_pattern/bloc_pattern.dart';

void main() => runApp(
      BlocProvider<HomeController>(
        bloc: HomeController(),
        child: MaterialApp(
          debugShowCheckedModeBanner: false,
          routes: <String, WidgetBuilder>{
            '/home': (BuildContext context) => new HomePage(),
          },
          home: HomePage(),
        ),
      ),
    );
