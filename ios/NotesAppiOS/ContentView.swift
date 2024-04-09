//
//  ContentView.swift
//  NotesAppiOS
//
//  Created by Sebastián Gallego Contreras on 9/4/24.
//

import SwiftUI
import common

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text(Platform_iosKt.getPlatformName())
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
