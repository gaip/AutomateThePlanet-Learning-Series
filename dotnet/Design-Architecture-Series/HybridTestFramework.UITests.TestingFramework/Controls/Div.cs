﻿// <copyright file="Div.cs" company="Automate The Planet Ltd.">
// Copyright 2018 Automate The Planet Ltd.
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

using ArtOfTest.WebAii.Controls.HtmlControls;
using HybridTestFramework.UITests.Core;
using HybridTestFramework.UITests.Core.Controls;
using Unity;

namespace HybridTestFramework.UITests.TestingFramework.Controls
{
    public class Div : ContentElement<HtmlDiv>, IDiv
    {
        public Div(IDriver driver,
            ArtOfTest.WebAii.ObjectModel.Element element,
            IUnityContainer container) : base(driver, element, container)
        {
        }
    }
}