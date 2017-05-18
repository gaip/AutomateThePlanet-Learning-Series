﻿// <copyright file="BingMainPage.cs" company="Automate The Planet Ltd.">
// Copyright 2017 Automate The Planet Ltd.
// Licensed under the Apache License, Version 2.0 (the "License");
// You may not use this file except in compliance with the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// </copyright>
// <author>Anton Angelov</author>
// <site>http://automatetheplanet.com/</site>

using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;

namespace HuddlePageObjectsPartialClassesCSharpSeven.ImprovedVersion
{
    public partial class BingMainPage
    {
        private readonly IWebDriver _driver;
        private readonly WebDriverWait _driverWait;
        private readonly string _url = @"http://www.bing.com/";

        // Prior C# 7.0
        ////public BingMainPage(IWebDriver browser)
        ////{
        ////    this._driver = browser;
        ////}

        // C# 7.0
        public BingMainPage(IWebDriver browser) => _driver = browser;


        // Prior C# 7.0
        ////public BingMainPage(WebDriverWait wait)
        ////{
        ////    if (wait == null)
        ////    {
        ////        throw new ArgumentNullException(nameof(wait));
        ////    }
        ////    this._driverWait = wait;
        ////}

        // C# 7.0
        public BingMainPage(WebDriverWait wait) => _driverWait = wait ?? throw new ArgumentNullException(nameof(wait));

        // Prior C# 7.0
        ////public void Navigate()
        ////{
        ////    this._driver.Navigate().GoToUrl(this.url);
        ////}

        // C# 7.0
        public void Navigate() => _driver.Navigate().GoToUrl(_url);

        public void Search(string textToType)
        {
            SearchBox = textToType;
            GoButton.Click();
        }
    }
}
