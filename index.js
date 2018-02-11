import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';

class WeatherComponent extends React.Component {
  render() {
    return (
      <View>
      <Text>Hello, world!</Text>
      </View>
    )
  }
}

AppRegistry.registerComponent('WeatherApp', () => WeatherComponent)
