package com.momo.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class AnnoPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('testTask') << {
            println "Hello gradle plugin"
        }
    }
}

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.api.ApplicationVariantImpl
//import org.gradle.api.Plugin
//import org.gradle.api.Project
//
//class AnnoPlugin implements Plugin<Project> {
//
//    @Override
//    void apply(Project project) {
//
//        println "momo plugin start"
//
//        project.afterEvaluate {
//            Project appProject
//            Set<Project> modules = project.rootProject.subprojects.findAll {
//                it.plugins.hasPlugin(MPlugin)
//            }
//            StringBuilder sb = new StringBuilder()
//            if (!modules.empty) {
//                modules.each { Project p ->
//                    if (p.plugins.hasPlugin(AppPlugin)) {
//                        appProject = p
//                    }
//                    sb.append(p.name.replace(".", "_")).append(",")
//                }
//            }
//            if (appProject == null) {
//                return
//            }
//            String validModuleName = appProject.name.replace('.', '_')
//            ((AppExtension) appProject.android).applicationVariants.all { ApplicationVariantImpl variant ->
//                variant.variantData.javacTask.options.compilerArgs.add("-AmoduleName=${validModuleName}")
//                println "sb " + sb
//                variant.buildConfigField("String", "MODULES_NAME", "\"$sb\"")
//            }
//        }
//    }
//}