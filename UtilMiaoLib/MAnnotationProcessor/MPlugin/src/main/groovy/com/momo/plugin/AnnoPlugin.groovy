package com.momo.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.api.ApplicationVariantImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

class AnnoPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        println "momo AnnoPlugin start"

        project.afterEvaluate {
            Project appProject
            Set<Project> libs = project.rootProject.subprojects.findAll {
                it.plugins.hasPlugin(AnnoPlugin)
            }
            println "momo libs " + libs
            StringBuilder sb = new StringBuilder()
            if (!libs.empty) {
                libs.each { Project p ->
                    if (p.plugins.hasPlugin(AppPlugin)) {
                        appProject = p
                    }
                    sb.append(p.name.replace('.', '_')).append(",")
                }
            }
            if (appProject == null) {
                return
            }
            //   在BuildConfig下生成   public static final String MODULES_NAME = "app,Module1,Module2";
            String validModuleName = appProject.name.replace('.', '_')
            ((AppExtension) appProject.android).applicationVariants.all { ApplicationVariantImpl variant ->
                variant.variantData.javacTask.options.compilerArgs.add("-AmoduleName=${validModuleName}")
                println "momo modules " + sb
                variant.buildConfigField("String", "MODULES_NAME", "\"$sb\"")
            }
        }
    }
}