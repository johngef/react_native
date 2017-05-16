'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules
} from 'react-native';

class HelloWorld extends React.Component {
 onBackAndroid() {
    this.pop();
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, World</Text>
      </View>
    )
  }
  componentDidMount(){
    NativeModules.CallBackNative.getData((msg) => {
        NativeModules.NativeToast.show(msg,NativeModules.NativeToast.SHORT);
    });
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);