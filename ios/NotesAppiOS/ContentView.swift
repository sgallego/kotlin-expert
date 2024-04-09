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
        ComposeView()
    }
}

struct ComposeView: UIViewControllerRepresentable{

    func makeUIViewController(context: Self.Context) -> UIViewController{
        MainKt.MainViewController()
    }
    
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    
    }
    
}

#Preview {
    ContentView()
}
